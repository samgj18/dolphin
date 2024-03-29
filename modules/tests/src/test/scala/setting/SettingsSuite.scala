// Copyright (c) 2022 by Samuel Gomez
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package dolphin.setting

import dolphin.Config
import dolphin.setting.{
  CreatePersistentSubscriptionToAllSettings as PS,
  CreatePersistentSubscriptionToStreamSettings as PSS
}

import com.eventstore.dbclient.*
import weaver.FunSuite

object SettingsSuite extends FunSuite {

  test("AppendToStreamSettings should return Java WriteStreamOptions") {
    val options = AppendToStreamOptions.get().getClass
    expect(AppendToStreamSettings.Default.toOptions.getClass == options)
  }

  test("CreatePersistentSubscriptionToAllSettings should return java CreatePersistentSubscriptionToAllOptions") {
    val options = CreatePersistentSubscriptionToAllOptions.get().getClass
    expect(PS.Default.toOptions.getClass == options)
  }

  test("CreatePersistentSubscriptionToStreamSettings should return java CreatePersistentSubscriptionToAllOptions") {
    val options = CreatePersistentSubscriptionToStreamOptions.get().getClass
    expect(PSS.Default.toOptions.getClass == options)
  }

  test("DeletePersistentSubscriptionSettings should return java DeletePersistentSubscriptionOptions") {
    val options = DeletePersistentSubscriptionOptions.get().getClass
    expect(DeletePersistentSubscriptionSettings.Default.toOptions.getClass == options)
  }

  test("DeleteStreamSettings should return Java DeleteStreamOptions") {
    val options = DeleteStreamOptions.get().getClass
    expect(DeleteStreamSettings.Default.toOptions.getClass == options)
  }

  test("EventStoreSettings should return default settings") {
    val options = Config.Default
    expect(!options.tls.tls) and expect(options.deadline.contains[Long](10_000)) and expect(
      !options.tlsVerifyCert
    ) and expect(
      !options.dnsDiscover
    )
  }

  test("GetPersistentSubscriptionInfoSettings should return java GetPersistentSubscriptionOptions") {
    val options = GetPersistentSubscriptionInfoOptions.get().getClass
    expect(GetPersistentSubscriptionInfoSettings.Default.toOptions.getClass == options)
  }

  test("ListPersistentSubscriptionSettings should return java ListPersistentSubscriptionOptions") {
    val options = ListPersistentSubscriptionsOptions.get().getClass
    expect(ListPersistentSubscriptionsSettings.Default.toOptions.getClass == options)
  }

  test("ReadFromStreamSettings should return Java ReadStreamOptions") {
    val options = ReadStreamOptions.get().getClass
    expect(ReadFromStreamSettings.Default.toOptions.getClass == options)
  }

  test("ReplayParkedMessagesSettings should return java ReplayParkedMessagesOptions") {
    val options = ReplayParkedMessagesOptions.get().getClass
    expect(ReplayParkedMessagesSettings.Default.toOptions.getClass == options)
  }

  test("RestartPersistentSubscriptionSettings should return java RestartPersistentSubscriptionOptions") {
    val options = RestartPersistentSubscriptionSubsystemOptions.get().getClass
    expect(RestartPersistentSubscriptionSubsystemSettings.Default.toOptions.getClass == options)
  }

  test("SubscriptionFilterSettings should return java SubscriptionFilter") {
    val options =
      SubscriptionFilter
        .newBuilder()
        .withEventTypeRegularExpression("^eventType-194$")
        .build()
        .getClass

    expect(
      SubscriptionFilterSettings
        .Default
        .withEventTypePrefix("^eventType-194$")
        .withStreamNamePrefix("^eventType-194$")
        .build
        .getClass == options
    )
  }

  test("SubscriptionToStreamSettings should return Java SubscribeToStreamOptions") {
    val options = SubscribeToStreamOptions.get().getClass
    expect(SubscriptionToStreamSettings.Default.toOptions.getClass == options)
  }

  test("UpdatePersistentSubscriptionToAllSettings should return java UpdatePersistentSubscriptionToAllOptions") {
    val options = UpdatePersistentSubscriptionToAllOptions.get().getClass
    expect(UpdatePersistentSubscriptionToAllSettings.Default.toOptions.getClass == options)
  }

  test("UpdatePersistentSubscriptionToStreamSettings should return java UpdatePersistentSubscriptionToStreamOptions") {
    val options = UpdatePersistentSubscriptionToStreamOptions.get().getClass
    expect(UpdatePersistentSubscriptionToStreamSettings.Default.toOptions.getClass == options)
  }

  test("AbortProjectionSettings should return java AbortProjectionOptions") {
    val options = AbortProjectionOptions.get().getClass
    expect(AbortProjectionSettings.Default.toOptions.getClass == options)
  }

  test("CreateProjectionSettings should return java CreateProjectionOptions") {
    val options = CreateProjectionOptions.get().getClass
    expect(CreateProjectionSettings.Default.toOptions.getClass == options)
  }

  test("DeleteProjectionSettings should return java DeleteProjectionOptions") {
    val options = DeleteProjectionOptions.get().getClass
    expect(DeleteProjectionSettings.Default.toOptions.getClass == options)
  }

  test("DisableProjectionSettings should return java DisableProjectionOptions") {
    val options = DisableProjectionOptions.get().getClass
    expect(DisableProjectionSettings.Default.toOptions.getClass == options)
  }

  test("EnableProjectionSettings should return java EnableProjectionOptions") {
    val options = EnableProjectionOptions.get().getClass
    expect(EnableProjectionSettings.Default.toOptions.getClass == options)
  }

  test("ResetProjectionSettings should return java ResetProjectionOptions") {
    val options = ResetProjectionOptions.get().getClass
    expect(ResetProjectionSettings.Default.toOptions.getClass == options)
  }

  test("UpdateProjectionSettings should return java UpdateProjectionOptions") {
    val options = UpdateProjectionOptions.get().getClass
    expect(UpdateProjectionSettings.Default.toOptions.getClass == options)
  }

  test("GetProjectionResultSettings should return java GetProjectionResultOptions") {
    val options = GetProjectionResultOptions.get().getClass
    expect(GetProjectionResultSettings.Default.toOptions.getClass == options)
  }

  test("GetProjectionStateSettings should return java GetProjectionStateOptions") {
    val options = GetProjectionStateOptions.get().getClass
    expect(GetProjectionStateSettings.Default.toOptions.getClass == options)
  }

  test("GetProjectionStatisticsSettings should return java GetProjectionStatisticsOptions") {
    val options = GetProjectionStatisticsOptions.get().getClass
    expect(GetProjectionStatisticsSettings.Default.toOptions.getClass == options)
  }

  test("GetProjectionStatusSettings should return java GetProjectionStatusOptions") {
    val options = GetProjectionStatusOptions.get().getClass
    expect(GetProjectionStatusSettings.Default.toOptions.getClass == options)
  }

  test("ListProjectionsSettings should return java ListProjectionsOptions") {
    val options = ListProjectionsOptions.get().getClass
    expect(ListProjectionsSettings.Default.toOptions.getClass == options)
  }

  test("RestartPersistentSubscriptionSettings should return java RestartPersistentSubscriptionOptions") {
    val options = RestartPersistentSubscriptionSubsystemOptions.get().getClass
    expect(RestartPersistentSubscriptionSubsystemSettings.Default.toOptions.getClass == options)
  }

  test("RestartProjectionSubsystemSettings should return java RestartProjectionSubsystemOptions") {
    val options = RestartProjectionSubsystemOptions.get().getClass
    expect(RestartProjectionSubsystemSettings.Default.toOptions.getClass == options)
  }
}
