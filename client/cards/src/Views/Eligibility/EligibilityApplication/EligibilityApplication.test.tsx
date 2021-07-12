import Enzyme, { shallow, render, mount } from 'enzyme';
import toJson from 'enzyme-to-json';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import EligibilityApplication from './EligibilityApplication';

Enzyme.configure({ adapter: new Adapter() })


let mockFn = jest.fn();

 
it(" EligibilityApplication Component renders correctly", () => {
  const testApplicaitonFormcomponent = shallow(<EligibilityApplication checkApplicantEligiblity={mockFn} />);
  expect(toJson(testApplicaitonFormcomponent)).toMatchSnapshot();
});
