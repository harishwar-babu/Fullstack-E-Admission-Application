import axios from "axios";

const USER_API_LINK = "http://localhost:8080/UserAdd";

class LoginService {
    check(values) {
        return axios.post("http://localhost:8080/authenticate", values);
    }
    createUser(user) {
        return axios.post(USER_API_LINK, user);
    }

    existsBymailId(mail, username) {
        return axios.get("http://localhost:8080/getByMailId" + "/" + mail + "&" + username);
    }

    checkCredentials(mail, password) {
        return axios.get(
            "http://localhost:8080/getByEmailandpassword" +
            "/" +
            mail +
            "&" +
            password
        );
    }

    getDetailByemail(mail) {
        return axios.get("http://localhost:8080/getByemail" + "/" + mail);
    }

    getDetailByusername(username) {
        return axios.get("http://localhost:8080/getByusername" + "/" + username);
    }
}
export default new LoginService();
