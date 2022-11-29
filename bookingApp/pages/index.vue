<template>
    <div>
        <div>
            <p class="mt-2 text-center" style="font-weight: 700; font-size: 250%;">Login</p>
            <p><img class="img"
                    src="https://upload.wikimedia.org/wikipedia/commons/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg">
            </p>
        </div>
        <div class="input">
        
            <v-text-field outlined rounded v-model.trim="form.user_username" label="Username"></v-text-field>
            <v-text-field outlined rounded type="password" v-model.trim="form.user_password" label="Password"></v-text-field>
           
        
        </div>
        <div class="text-center">
            <v-btn  rounded color="green" dark @click="onSignin">
                Sign in
            </v-btn>
            <v-btn class="signup"  rounded color="primary" dark to="/Regis">
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
                user_username: "",
                user_password: ""
            },
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
        onSignin() {

            Axios.get("/api/getAllUsers").then((res) => {
                var user = res.data
                console.log("user", user);
                var login = user.find((data) => data.username == this.form.user_username && data.password == this.form.user_password)
                console.log(login)
                if (login == undefined) {
                    alert("Incorrect username or password.");
                } else {
                    sessionStorage.setItem("users", JSON.stringify(login));
                    this.$router.push({ path: "/BookingBook" });

                }

            })
        }
    }
}
</script>

<style>
.signup {
    margin: 20px;
}

.img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 40%;
    height: 40%;
}

.input {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 40%;
}
</style>