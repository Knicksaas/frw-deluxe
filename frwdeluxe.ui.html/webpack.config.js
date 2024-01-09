const baseConfig = require('@eclipse-scout/cli/scripts/webpack-defaults');

module.exports = (env, args) => {
  args.resDirArray = ['src/main/resources/WebContent', 'node_modules/@eclipse-scout/core/res'];
  const config = baseConfig(env, args);

  config.entry = {
    'frwdeluxe': './src/main/js/frwdeluxe.ts',
    'login': './src/main/js/login.ts',
    'logout': './src/main/js/logout.ts',
    'frwdeluxe-theme': './src/main/js/frwdeluxe-theme.less',
    'frwdeluxe-theme-dark': './src/main/js/frwdeluxe-theme-dark.less'
  };

  return config;
};
