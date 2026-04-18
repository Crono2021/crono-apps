.class public Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AutosaveSettingsException"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x586bf5c8


# instance fields
.field public chatId:J

.field public settings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23045
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "scopeAutosaveSettings"    # Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 23034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23035
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;->chatId:J

    .line 23036
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettingsException;->settings:Lorg/drinkless/tdlib/TdApi$ScopeAutosaveSettings;

    .line 23037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23041
    const v0, 0x586bf5c8

    return v0
.end method
