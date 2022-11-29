<template>
    <div>
        <div>
            <h3 class="mt-2 text-center" style="font-weight: 700; font-size: 250%;">Register</h3>
            <br>
            <p><img class="img"
                    src="https://upload.wikimedia.org/wikipedia/commons/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg">
            </p>
        </div>
        <br>
        <div class="input">
            <v-text-field outlined rounded v-model.trim="form.user_name" label="Full name"></v-text-field>
            <v-text-field outlined rounded v-model.trim="form.user_username" label="Username"></v-text-field>
            <v-text-field outlined rounded type="password" v-model.trim="form.user_password" label="Password"></v-text-field>
            <v-text-field outlined rounded type="password" v-model.trim="confirm_password" label="Comfirm password"></v-text-field>
        </div>
        <div class="text-center">
            <v-btn  rounded class="cen mb-5" color="primary" dark @click="onSignup">
                Sign up
            </v-btn>
        </div>
    </div>
</template>

<script>
import Axios from "axios";
export default {
    component: {
    },
    name: 'Login',
    data() {
        return {
            form: {
                user_name: "",
                user_username: "",
                user_password: "",
            },
            confirm_password: "",
        };

    },
    computed: {},
    watch: {},
    mounted() {
    },
    created() {

    },
    beforeDestroy() {

    },
    methods: {
        onSignup() {
            console.log("form", this.form);
            if (this.form.user_password == this.confirm_password) {
                Axios.post(`/api/addUser`, {
                    name: this.form.user_name,
                    username: this.form.user_username,
                    password: this.form.user_password
                }).then((res) => {
                    alert("Complete");
                    this.$router.push({ path: "/" });
                })
            } else {
                alert("Uncomplete");
            }
            this.reset();
        },
        reset(){
            this.form.user_username = "",
            this.form.user_password = "",
            this.confirm_password = ""
        }
    }
}
</script>

<style scoped>
.img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 25%;
    height: 25%;
}

.input {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 30%;
}

h3 {
  font-family:"Merienda";
}
</style>