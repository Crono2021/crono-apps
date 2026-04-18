.class public Lorg/drinkless/tdlib/TdApi$AddChatMember;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddChatMember"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x66875217


# instance fields
.field public chatId:J

.field public forwardLimit:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35332
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35333
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 35321
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35322
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddChatMember;->chatId:J

    .line 35323
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AddChatMember;->userId:J

    .line 35324
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$AddChatMember;->forwardLimit:I

    .line 35325
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35329
    const v0, 0x66875217

    return v0
.end method
