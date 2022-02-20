import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';

{/* container - bootstrap css class) */}
function App() {
  return (
    <div className="container">
      <ListEmployeeComponent />

    </div>
  );
}

export default App;
