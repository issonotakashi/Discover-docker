<template>
  <div class="department-list">
    <a-row type="flex" justify="center">
      <a-col :xs="24" :sm="22" :md="12" :lg="8" :xl="5">
        <a-row class="department" v-for="student in students" :key="student.id">
          <a-col :span="12">{{ student.id }}</a-col>
          <a-col :span="12">{{ student.firstName }} {{ student.lastName }}</a-col>
          <a-col :span="24" style="font-size: 12px; color: #666;">{{ student.department.name }}</a-col>
        </a-row>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: "DepartmentList",
  props: {
    msg: String
  },
  data: function() {
    return {
      students: []
    };
  },
  mounted: function() {
    fetch(`${process.env.VUE_APP_API_URL}/students`)
      .then(response => response.json())
      .then(data => (this.students = data));
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
a {
  color: #232323;
}
a:hover {
  color: #232323;
}
.department:hover {
  background-color: #face53;
}
</style>