import AppRouter from './Routes'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {

  return (
    <>
      <AppRouter />
      <ToastContainer theme="dark" autoClose={10000}/>
    </>
  )
}

export default App
