.class public Lorg/drinkless/tdlib/TdApi$ChatJoinRequests;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatJoinRequests"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4cfd7b07


# instance fields
.field public requests:[Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24225
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatJoinRequestArr"    # [Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;

    .line 24214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24215
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatJoinRequests;->totalCount:I

    .line 24216
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatJoinRequests;->requests:[Lorg/drinkless/tdlib/TdApi$ChatJoinRequest;

    .line 24217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24221
    const v0, 0x4cfd7b07    # 1.32896824E8f

    return v0
.end method
