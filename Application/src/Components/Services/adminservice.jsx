import axiosObject from "./axiosObject";

class adminservice {
    addClg(clg)
    {
        return axiosObject.post("http://localhost:8080/AddClg",clg);
    }
    fetchCollegeList()
    {
        return axiosObject.get("http://localhost:8080/ViewClg");
    }
    deleteClgs(id)
    {
        return axiosObject.delete("http://localhost:8080/deleteClg" +"/"+id);
    }
    updatecollegedetailsbyid(id,values)
    {
        return axiosObject.put("http://localhost:8080/Clgupdate"+"/"+id,values);
    }
    fetchCollgeById(id)
    {
        return axiosObject.get("http://localhost:8080/ViewClg"+"/"+id);
    }
    fetchUserList()
    {
        return axiosObject.get("http://localhost:8080/view");
    }
    Count(name)
    {
        return axiosObject.get("http://localhost:8080/count"+"/"+name);
    }
    ChoiceList()
    {
        return axiosObject.get("http://localhost:8080/choices");
    }

} 
export default new adminservice();