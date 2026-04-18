.class public Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatJoinRequestsInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x34f5f5bf


# instance fields
.field public totalCount:I

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24245
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 24234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24235
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;->totalCount:I

    .line 24236
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;->userIds:[J

    .line 24237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24241
    const v0, 0x34f5f5bf

    return v0
.end method
