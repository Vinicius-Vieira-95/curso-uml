import "./style.css"
import linkedInIcon from "./icons/linkedin-svgrepo-com.png"
import githubIcon from "./icons/github-142-svgrepo-com.png"


function Footer() {

    return (
        <footer className="main-foooter">
            <div className="footer-icons">
                <a href="https://github.com/Vinicius-Vieira-95">
                   <img src={githubIcon} alt="Github Icon" className="size-img-small"/>
                </a>
                <a href="https://www.linkedin.com/in/vinicius-vieira-46391011a/">
                    <img src={linkedInIcon} alt="LinkedIn Icon" className="size-img-small"/>
                </a>
            </div>
        </footer>
    )
}

export default Footer