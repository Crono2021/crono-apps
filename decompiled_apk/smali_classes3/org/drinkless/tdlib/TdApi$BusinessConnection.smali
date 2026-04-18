.class public Lorg/drinkless/tdlib/TdApi$BusinessConnection;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessConnection"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3b593c7d


# instance fields
.field public date:I

.field public id:Ljava/lang/String;

.field public isEnabled:Z

.field public rights:Lorg/drinkless/tdlib/TdApi$BusinessBotRights;

.field public userChatId:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49450
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49451
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJILorg/drinkless/tdlib/TdApi$BusinessBotRights;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "i9"    # I
    .param p7, "businessBotRights"    # Lorg/drinkless/tdlib/TdApi$BusinessBotRights;
    .param p8, "z8"    # Z

    .line 49436
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49437
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnection;->id:Ljava/lang/String;

    .line 49438
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnection;->userId:J

    .line 49439
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnection;->userChatId:J

    .line 49440
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnection;->date:I

    .line 49441
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnection;->rights:Lorg/drinkless/tdlib/TdApi$BusinessBotRights;

    .line 49442
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$BusinessConnection;->isEnabled:Z

    .line 49443
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49447
    const v0, -0x3b593c7d

    return v0
.end method
