<template>
  <div>
  <el-menu
      router
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      default-active="Home"
      style="height: 100vh;"
      :collapse="isCollapse"
      :collapse-transition="false">
    <el-menu-item index="Home" :route="{ path: '/home' }">
        <i class="el-icon-s-home"></i><span>首页</span>
    </el-menu-item>
    <el-menu-item index="销售管理" :route="{ path: '/sale' }">
      <i class="el-icon-s-shop"></i><span>销售管理</span>
    </el-menu-item>
    <el-menu-item index="客户管理" :route="{ path: '/customer' }">
      <i class="el-icon-chat-dot-round"></i><span>客户管理</span>
    </el-menu-item>
      <el-menu-item index="库存管理" :route="{ path: '/inventory' }">
      <i class="el-icon-chat-dot-round"></i><span>库存管理</span>
    </el-menu-item>
    <el-menu-item index="财务报表" :route="{ path: '/form' }">
      <i class="el-icon-chat-dot-round"></i><span>财务报表</span>
    </el-menu-item>
    <el-menu-item index="员工管理" :route="{ path: '/employee' }">
      <i class="el-icon-chat-dot-round"></i><span>员工管理</span>
    </el-menu-item>
    <el-menu-item></el-menu-item>

  </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Aside',
  props:{
    isCollapse:Boolean
  }

}
</script>



<style scoped>
a{
  text-decoration: none;
  color: #eeeeee;
}
.router-link-active {
  text-decoration: none;
  color: #eeeeee;
}
/*隐藏文字*/
.el-menu--collapse .el-submenu__title span {
  display: none;
}
/*隐藏 > */
.el-menu--collapse .el-submenu__title .el-submenu__icon-arrow {
  display: none;
}
</style>