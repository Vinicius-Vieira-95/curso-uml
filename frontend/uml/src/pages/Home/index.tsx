import { useState } from "react";
import Footer from "../Footer"
import "./style.css"
import { useNavigate } from "react-router-dom";
import { loginUser } from "../../api";
import { toast } from 'react-toastify';

function Home() {
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');

    const navigate = useNavigate();

    const handleEmail = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setEmail(event.target.value);
    };

    const handleSenha = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setSenha(event.target.value);
    };

    function handlelogin(event: React.MouseEvent<HTMLButtonElement>) {
        event.preventDefault();
        const user = {
            login: email,
            senha: senha
        }

        loginUser(user).then((response) => {
            if (response.status === 200) {
                navigate("/user")
            }
            console.log(response.status)
            toast.error("Error ao fazer login")
        })
    }

    return (
        <>
            <div className="login-container">
                <div className="login-box">
                    <h2>Login</h2>
                    <form>
                        <div className="input-box">
                            <input type="text" required value={email} onChange={handleEmail} maxLength={100} />
                            <label>Nome de Usuário</label>
                        </div>
                        <div className="input-box">
                            <input type="password" required value={senha} onChange={handleSenha} maxLength={20} />
                            <label>Senha</label>
                        </div>
                        <button type="submit" className="login-btn" onClick={handlelogin}>Acessar</button>
                    </form>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default Home 