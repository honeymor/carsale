<script>
export default {
  name: "login",
  data() {
    return {
      disable_confirm:false,
      loginForm: {
        name: '',
        password: ''
      },
      rules: {
        name: [
          {required: true, message: '请输入账号', trigger: 'blur'},
          {min: 3, max: 6, message: '用户名长度在 3 到 6 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输密码', trigger: 'blur'},
          {min: 3, max: 6, message: '密码长度在 3 到 6 个字符', trigger: 'blur'}
        ]
      }

    }
  },
  methods: {
    confirm() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loginRequest(); // 进行登录请求
        } else {
          this.$message.error('请检查输入信息');
          return false;
        }
      });
    },
    // 登录请求
    loginRequest() {
      this.$axios.post('/api/login', this.loginForm)
          .then(response => {
            const data = response.data;

            if (data) {
              this.$message.success('登录成功');
              this.$router.push({path: this.redirect || '/Index'});
            } else {
              this.$message.error(data.message || '用户名或密码错误');
            }
          })
          .catch(error => {
            this.$message.error('登录请求失败，请稍后重试');
            console.error(error);
          });
    },

  }
}
</script>

<template>
  <div class="login-container">
<!--    <div id="img-box" style="transform: scale(1.1);">-->
<!--      <img src="@/assets/img/loginImg/img.jpg"  alt="">-->
<!--    </div>-->
    <div id="left" style="transform: scale(1.1)">
      <div class="icon-container">
        <div>
          <i class="fas fa-circle"></i>
        </div>
      </div>
    </div>
    <el-form ref="loginForm" :model="loginForm" :rules="rules" label-width="auto" style="transform: scale(1.1);">
      <div id="title-container" >
        <div id="title">汽车销售系统</div>
      </div>
      <el-form-item label="账号" prop="name" >
        <el-input style="width: 250px "  v-model="loginForm.name" size="big"  prefix-icon="el-icon-user"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password" >
        <el-input style="width: 250px;margin-top: 15px"  v-model="loginForm.password"
                  show-password  size="big" @keyup.enter.native="confirm" prefix-icon="el-icon-lock" ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="info" round @click="confirm" :disabled="disable_confirm" style="width: 200%;margin-left: -60%; margin-top: 30px"  >登 录</el-button>
      </el-form-item>
      <div id="other">
        <a style="margin-right: 50px">忘记密码 ?</a>
        <a >注册</a>
      </div>
    </el-form>
  </div>
</template>

<style scoped>
* {
  padding: 0;
  margin: 0;
  outline: none;
}
body {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.login-container{
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #B3C0D1;

  #left{
    width: 330px;
    height: 520px;
    box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
    border-radius: 15px;
    background-color: #545c64;
    display: flex; /* 使用 flexbox 使内容居中 */
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
    .icon-container {
      display: flex; /* 使用 flexbox 使内容居中 */
      justify-content: center; /* 水平居中 */
      align-items: center; /* 垂直居中 */
      width: 100px; /* 设置容器宽度 */
      height: 100px; /* 设置容器高度 */
      border-radius: 10px; /* 可选：圆角 */
    }

    .icon-container .el-icon-truck {
      font-size: 48px; /* 设置图标大小 */
      color: #ffffff; /* 设置图标颜色 */
    }

  }
  .el-form {
    width: 562px;
    height: 520px;
    background-color: #fff;
    box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
    border-radius: 0 15px 15px 0;;
    display: flex;
    justify-content: center;
    align-items: center;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  }
  #title-container {
    width: 100%;
    text-align: center;
    line-height: 1;
    position: relative;
    margin-bottom: 40px;
    margin-right: -30px;
  }

  #title {
    color: #7f7f7f;
    font-size: 20px;
  }
  #other{
    font-size: 12px;
    margin-top: 10px;
    margin-left: 20px;
    color: #868686;
  }

}
</style>
//#img-box {
//  width: 330px;
//  height: 520px;
//}

//#img-box img {
//  height: 100%;
//  width: 100%;
//  box-shadow: 0px 15px 40px #3c570f;
//  border-radius: 15px;
//}

//background-image: url("@/assets/img/loginImg/background.jpg");
//background-size: 100% 100%;
//background-repeat: no-repeat;