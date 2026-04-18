.class public Lorg/drinkless/tdlib/TdApi$UpdateChatBusinessBotManageBar;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatBusinessBotManageBar"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x41cf1809


# instance fields
.field public businessBotManageBar:Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33969
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$BusinessBotManageBar;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "businessBotManageBar"    # Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;

    .line 33958
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33959
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatBusinessBotManageBar;->chatId:J

    .line 33960
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatBusinessBotManageBar;->businessBotManageBar:Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;

    .line 33961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33965
    const v0, -0x41cf1809

    return v0
.end method
