.class public Lorg/drinkless/tdlib/TdApi$AutosaveSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AutosaveSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x611edc96


# instance fields
.field public channelSettings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

.field public exceptions:[Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;

.field public groupSettings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

.field public privateChatSettings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42415
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;[Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;)V
    .locals 0
    .param p1, "scopeAutosaveSettings"    # Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;
    .param p2, "scopeAutosaveSettings2"    # Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;
    .param p3, "scopeAutosaveSettings3"    # Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;
    .param p4, "autosaveSettingsExceptionArr"    # [Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;

    .line 42402
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42403
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettings;->privateChatSettings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 42404
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettings;->groupSettings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 42405
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettings;->channelSettings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 42406
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettings;->exceptions:[Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;

    .line 42407
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42411
    const v0, 0x611edc96

    return v0
.end method
