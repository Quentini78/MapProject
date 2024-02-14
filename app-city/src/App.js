import './App.css';
import Cities from './components/Cities';
import SvgImage from './components/SvgImage';

const App = () => {
  return (
    <div className="App">
      <div className="map-container">
        <Cities/>
        <SvgImage/>
      </div>
    </div>
  );
};

export default App;