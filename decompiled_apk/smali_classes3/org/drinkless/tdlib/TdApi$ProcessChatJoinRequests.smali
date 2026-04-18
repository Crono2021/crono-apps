.class public Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequests;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProcessChatJoinRequests"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e823dce


# instance fields
.field public approve:Z

.field public chatId:J

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39052
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39053
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z

    .line 39041
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39042
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequests;->chatId:J

    .line 39043
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequests;->inviteLink:Ljava/lang/String;

    .line 39044
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ProcessChatJoinRequests;->approve:Z

    .line 39045
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39049
    const v0, 0x3e823dce

    return v0
.end method
