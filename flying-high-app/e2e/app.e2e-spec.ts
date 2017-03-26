import { FlyingHighAppPage } from './app.po';

describe('flying-high-app App', function() {
  let page: FlyingHighAppPage;

  beforeEach(() => {
    page = new FlyingHighAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
