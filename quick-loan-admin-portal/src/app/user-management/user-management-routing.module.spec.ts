import { UserManagementRoutingModule } from './user-management-routing.module';

describe('UserManagementRoutingModule', () => {
  let userManagementRoutingModule: UserManagementRoutingModule;

  beforeEach(() => {
    userManagementRoutingModule = new UserManagementRoutingModule();
  });

  it('should create an instance', () => {
    expect(userManagementRoutingModule).toBeTruthy();
  });
});
