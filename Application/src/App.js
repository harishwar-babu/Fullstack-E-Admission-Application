import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Signup from "./Components/Signup-Component/signup";
import { AuthProvider } from "./auth.js";
import { RequireAuthentication } from "./requireauth.js"
import Admindashboardviewcolleges from "./Components/Admin-Component/AdminViewColleges";
import Login from "./Components/Login-Component/Login.jsx"
import Home from "./Components/Home/Home.jsx";
import Error from "./Error";
import AdminDashBoard from "./Components/Admin-Component/AdminDashBoard";
import AddCollege from "./Components/Admin-Component/AddCollegeFormCss";
import Admindashboardviewusers from "./Components/Admin-Component/AdminViewUsers";
import CustomerDashBoard from "./Components/Customer-Component/CustomerDashBoard";
import Admindashboardupdateviewcolleges from "./Components/Admin-Component/AdminUpdateColleges";
import UpdateCollege from "./Components/Admin-Component/UpdateCollegeProfileCss";
import AddForm from "./Components/Customer-Component/ApplicationFormCss";
import ChoiceForm from "./Components/Customer-Component/ChoiceConfirmationFormCss";
import Admindashboardviewchoices from "./Components/Admin-Component/ChoiceSelection";
function App() {
  return (
    <AuthProvider>
      <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="*" element={<Error />} />
            <Route path="Login" element={<Login/>} />
            <Route path="signup" element={<Signup />} />
            <Route
              path="admin"
              element={
                <RequireAuthentication>
                  <AdminDashBoard/>
                </RequireAuthentication>
              }
            >
              <Route path="ViewColleges" element={<Admindashboardviewcolleges/>}/>
              <Route path="addCollege" element={<AddCollege />} />
              <Route
                path="CollegeProfile"
                element={<Admindashboardupdateviewcolleges />}
              >
                <Route
                  path="UpdateCollegeProfile/:id"
                  element={<UpdateCollege />}
                />
              </Route>
              <Route path="ViewUsers" element={<Admindashboardviewusers />}>
                </Route>
              <Route path="UserChoiceSelection" element={<Admindashboardviewchoices />} />
                </Route>
            <Route
              path="customer"
              element={
                <RequireAuthentication>
                  <CustomerDashBoard />
                </RequireAuthentication>
              }
            >
              <Route path="submitForm" element={<AddForm />} >
              </Route>
              <Route path="choiceConfirm" element={<ChoiceForm/>}/>
              </Route>
                </Routes>
                </BrowserRouter>
                </div>
                </AuthProvider>
  )
}
export default App;