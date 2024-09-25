<script>
export default {
  name: "Main",
  data() {
    return {
      tableData: [],
      pageSize: 10,
      pageNum: 0,
      total: 0,
      id: null,
      status: null,
      statuses: [{
          value: '0',
          label: '未处理'
        },
          {
            value: '1',
            label: '已支付'
          }, {
            value: '2',
            label: '已发货'
          },{
          value: '',
          label: '全部'
        }],
      dialogVisible: false,
      form:{
          id: null,
          seriesId:null,
          type: null,
          color: null,
          price: null,
          salePrice: null,
          repertory: null,
          createTime: null,
          status: null
      },
      rules: {
        id: [
          { required: true, message: 'ID 不能为空', trigger: 'blur' },
          { pattern: /^(0|[1-9][0-9]*)$/, message: 'ID 必须是数字', trigger: 'blur' }
        ],
        seriesId: [
          { required: true, message: '系列ID 不能为空', trigger: 'blur' },
          { pattern: /^(0|[1-9][0-9]*)$/, message: '系列ID 必须是数字', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '类型不能为空', trigger: 'blur' }
        ],
        color: [
          { required: true, message: '颜色不能为空', trigger: 'blur' }
        ],
        price: [
          { required: true, message: '价格不能为空', trigger: 'blur' },
          { pattern: /^(0|[1-9][0-9]*)$/,message: '价格必须是数字', trigger: 'blur' }
        ],
        repertory: [
          { required: true, message: '库存不能为空', trigger: 'blur' },
          { pattern: /^(0|[1-9][0-9]*)$/, message: '库存必须是数字', trigger: 'blur' }
        ],
        status: [
          { required: true, message: '状态不能为空', trigger: 'blur' },
          {pattern: /^(0|[1-9][0-9]*)$/, message: '状态必须是数字', trigger: 'blur' }
        ],
      },
      nowid:null
    }
  },
  methods:{
    deleteCar(id){
      this.$axios.delete(`/api/car/${id}`).then(response=>{
        console.log(response)
      }).catch(error=>{
        console.error(error)
      })
    },
    async Delete(id) {
      try {
        // 删除操作
        await this.deleteCar(id);
        // 删除成功后，刷新数据
        await this.loadPost();
        this.$message.success("删除成功")
      } catch (error) {
        // 处理删除失败的情况
        console.error("删除失败", error);
      }
    }
    ,
    edit(row){
      this.dialogVisible = true
      this.$nextTick(()=>{
        this.form.id=row.id
        this.form.seriesId=row.seriesId
        this.form.type=row.type
        this.form.color=row.color
        this.form.price=row.price
        this.form.salePrice=row.salePrice
        this.form.repertory=row.repertory
        this.form.createTime=row.createTime
        this.form.status=row.status
        this.nowid=row.id
      })
    },
    resetForm() {
      this.$refs.form.resetFields();
    },
    save(){
      this.$refs.form.validate((valid) => {
        if (valid) {
          if(this.nowid!=null&&this.nowid!=this.form.id){
            this.$message.error('禁止修改id');
            return false;
          }
          this.$axios.post('/api/car/save', this.form).then(
              response=>console.log(response),
              this.dialogVisible = false, // 关闭对话框
              this.loadPost(),
              this.$message({
                message: '恭喜你，这是一条成功消息',
                type: 'success'
              })
          ).catch(err=>{
            console.error(err);
            this.$message.error('错了哦，这是一条错误消息');
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    add(){
      this.dialogVisible=true
      this.nowid=null
      this.$nextTick(()=>{
        this.resetForm();
      })
    },
    loadGet(){
      this.$axios.get('/api/car/list').then(res=>res.data).then(res=>{
        console.log(res)
        this.tableData=res
      }).catch(err => {
        console.error(err);
      });
    },
    loadPost() {
      this.$axios.post('/api/car/page', {
        pageNum:this.pageNum,
        pageSize:this.pageSize,
        param:{
          id: this.id,
          status: this.status,
        }
      }).then(response => {
        const res = response.data; // 获取响应体数据
        this.tableData = res.records; // 更新表格数据
        this.total = res.total; // 更新总记录数
      }).catch(error => {
        console.error("Error loading data:", error);
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageNum=1
      this.pageSize=val
      this.loadPost()
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageNum=val
      this.loadPost()
    }
  },
  beforeMount() {
    this.loadPost()
  },
}
</script>

<template>
  <div class="container">
    <div class="header">
      <el-input v-model="id"  placeholder="请输入id" style="width: 200px;margin: 5px" size="small" suffix-icon="el-icon-search"
      @keyup.enter.native="loadPost"></el-input>
      <el-select v-model="status" placeholder="请选择车辆状态" size="small">
          <el-option
              v-for="item in statuses"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
      </el-select>
      <el-button type="primary" size="mini" @click="loadPost">查询</el-button>
      <el-button type="danger" size="mini" style="margin-left:5px">重置</el-button>
      <el-button type="info" size="mini" style="margin-left:5px" @click="add">新增</el-button>
    </div>
  <el-table :data="tableData"
            :header-cell-style="{background:'#f3f6fd',color:'#555',textAlign:'center'}"
            :cell-style="{textAlign:'center'}"
              border>
    <el-table-column prop="id" label="id" width="120">
    </el-table-column>
    <el-table-column prop="seriesId" label="seriesId" width="120" >
    </el-table-column>
    <el-table-column prop="type" label="type">
    </el-table-column>
    <el-table-column prop="color" label="color">
    </el-table-column>
    <el-table-column prop="price" label="Price">
    </el-table-column>
    <el-table-column prop="salePrice" label="salePrice">
    </el-table-column>
    <el-table-column prop="repertory" label="reportory">
    </el-table-column>
    <el-table-column prop="createTime" label="createTime">
    </el-table-column>
    <el-table-column prop="status" label="status">
      <template slot-scope="scope">
        <el-tag
            :type="scope.row.status === '0' ? 'warning' : scope.row.status === '1' ? 'info' : 'success'"
            disable-transitions>
          {{ scope.row.status === '0' ? '未处理' : scope.row.status === '1' ? '已支付' : '已发货' }}
        </el-tag>
      </template>

    </el-table-column>
    <el-table-column prop="operation" label="operation">
      <template slot-scope="scope">
      <el-button type="success" size="mini" @click="edit(scope.row)">编辑</el-button>
        <el-popconfirm
            confirm-button-text='确认'
            cancel-button-text='取消'
            icon="el-icon-info"
            icon-color="red"
            title="确定删除吗？"
            @confirm="Delete(scope.row.id)"
        >
          <el-button slot="reference" type="danger" size="mini" style="margin-left: 5px">删除</el-button>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        style="text-align: center;position: relative;left: -60px;top:20px ;bottom: 40px"
        >
    </el-pagination>
    <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose"
        :center="true"
        style="">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" size="mini">
        <el-form-item label="编号" prop="id">
          <el-col :span="15">
          <el-input v-model="form.id"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="seriesId" prop="seriesId">
          <el-col :span="15">
            <el-input v-model="form.seriesId"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-col :span="15">
            <el-input v-model="form.type"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="颜色" prop="color">
          <el-col :span="15">
            <el-input v-model="form.color"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-col :span="15">
            <el-input v-model="form.price"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-col :span="15">
            <el-input v-model="form.status"></el-input>
          </el-col>
        </el-form-item>
        </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save">确 定</el-button>
  </span>
    </el-dialog>
    </div>
</template>

<style scoped>
.el-table{
  margin: 5px 0px 0px 0px;
  box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;
  width: 95%;
  position: relative;
  left: 2.5%;
}
.header{
  position: relative;
  left: 2.5%;
  border: 0.5px solid lightgray;
  margin: 5px 0px 0px 0px;
  padding: 0px 5px;
  display: inline-block;
  box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
}



</style>