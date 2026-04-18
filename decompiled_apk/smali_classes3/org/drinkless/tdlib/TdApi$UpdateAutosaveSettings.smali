.class public Lorg/drinkless/tdlib/TdApi$UpdateAutosaveSettings;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAutosaveSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x25d8b0f5


# instance fields
.field public scope:Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;

.field public settings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33769
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;)V
    .locals 0
    .param p1, "autosaveSettingsScope"    # Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;
    .param p2, "scopeAutosaveSettings"    # Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 33758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33759
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAutosaveSettings;->scope:Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;

    .line 33760
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateAutosaveSettings;->settings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 33761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33765
    const v0, -0x25d8b0f5

    return v0
.end method
