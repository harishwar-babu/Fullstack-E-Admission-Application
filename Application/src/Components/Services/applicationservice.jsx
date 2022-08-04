import axiosObject from "./axiosObject";

class applicationservice
{
    submit(appln)
    {
        return axiosObject.post("http://localhost:8080/submit", appln);
    }
    confirmation(values)
    {
        return axiosObject.post("http://localhost:8080/confirm",values)
    }
}
export default new applicationservice();