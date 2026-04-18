.class public Lorg/drinkless/tdlib/TdApi$ChatActionUploadingVideo;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionUploadingVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x49902c36


# instance fields
.field public progress:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9636
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9637
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9627
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9628
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionUploadingVideo;->progress:I

    .line 9629
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9633
    const v0, 0x49902c36

    return v0
.end method
