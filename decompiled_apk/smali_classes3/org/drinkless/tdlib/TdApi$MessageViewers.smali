.class public Lorg/drinkless/tdlib/TdApi$MessageViewers;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageViewers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7e26ed1f


# instance fields
.field public viewers:[Lorg/drinkless/tdlib/TdApi$MessageViewer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16962
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16963
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$MessageViewer;)V
    .locals 0
    .param p1, "messageViewerArr"    # [Lorg/drinkless/tdlib/TdApi$MessageViewer;

    .line 16953
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16954
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageViewers;->viewers:[Lorg/drinkless/tdlib/TdApi$MessageViewer;

    .line 16955
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16959
    const v0, 0x7e26ed1f

    return v0
.end method
