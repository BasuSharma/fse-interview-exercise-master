import Enzyme, { shallow, render, mount } from 'enzyme';
import toJson from 'enzyme-to-json';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import EligibilityContainer from './EligibilityContainer';

Enzyme.configure({ adapter: new Adapter() })


it(" EligibilityContainer renders correctly", () => {
    const eligibilityContainer = shallow(<EligibilityContainer />);
    expect(toJson(eligibilityContainer)).toMatchSnapshot();
});
