.class public Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatCreated;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventVideoChatCreated"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6ca68a7b


# instance fields
.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10086
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10087
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10077
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10078
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatCreated;->groupCallId:I

    .line 10079
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10083
    const v0, 0x6ca68a7b

    return v0
.end method
