.class public Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScopeChat;
.super Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AutosaveSettingsScopeChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x614a3d17


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;-><init>()V

    .line 8989
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 8979
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScope;-><init>()V

    .line 8980
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AutosaveSettingsScopeChat;->chatId:J

    .line 8981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8985
    const v0, -0x614a3d17

    return v0
.end method
