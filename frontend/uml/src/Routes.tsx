import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Profile from "./pages/User";

const AppRouter: React.FC = () => {

    return (
        <BrowserRouter>
            <Routes>
                <Route path="/home" element={<Home />} />
                <Route path="/user" element={<Profile />} />
            </Routes>
        </BrowserRouter>
    );
}

export default AppRouter