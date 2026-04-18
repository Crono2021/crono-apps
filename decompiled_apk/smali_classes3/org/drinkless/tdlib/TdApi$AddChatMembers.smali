.class public Lorg/drinkless/tdlib/TdApi$AddChatMembers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddChatMembers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x63e59921


# instance fields
.field public chatId:J

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22725
    return-void
.end method

.method public constructor <init>(J[J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J

    .line 22714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22715
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddChatMembers;->chatId:J

    .line 22716
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddChatMembers;->userIds:[J

    .line 22717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22721
    const v0, -0x63e59921

    return v0
.end method
