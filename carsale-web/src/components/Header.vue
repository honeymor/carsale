<script>

export default {
  name: "Header",
  methods:{
    collapse(){
      this.$emit('doCollapse')
    },
    logout(){
      this.$confirm('此操作将退出登录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '退出成功!'
        });
        this.$router.push({path:'/'})
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消退出'
        });
      });
    },
    touser(){
      this.$router.push('/user')
    }
  },
  props:{
    icon:String
  }


}
</script>

<template>
  <div style="display: flex;line-height: 60px;font-size: 24px;justify-items: center ">
    <div>
      <i :class="icon" @click="collapse"></i>
    </div>
    <div style="flex: 1;text-align: center;font-size: 20px">
      <span>欢迎来到汽车销售管理系统</span>
    </div>
    <el-dropdown>
      <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px;margin-right: 15px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click.native="touser">个人中心</el-dropdown-item>
        <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<style scoped>

</style>