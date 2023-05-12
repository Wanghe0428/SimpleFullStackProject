<template>
  <div class="home">

    home is {{ name }}
    <div v-for="(item, index) in userlist" :key="index">
      {{ `${item.id}: 用户名是${item.userName}；用户密码是${item.password}，其生日是${item.birthday}`}}
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Vue from "vue"
import axios from "axios"
import $http from "../util/request"
export default {
  name: 'Home',
  data() {
    return {
      name: "wh",
      userlist: [{ userName: "wh" }]
    }
  },
  async created() {
    // axios.get("/userDb/find").then((res) =>{
    //   console.log(res);
    //   this.userlist = res.data;
    // })
    let list = await $http.get("/userDb/find");
    console.log(list);
    this.userlist = list;
    
  },
  mounted() {
    console.log("list:", this.userlist);
  },
  components: {
  }
}
</script>
