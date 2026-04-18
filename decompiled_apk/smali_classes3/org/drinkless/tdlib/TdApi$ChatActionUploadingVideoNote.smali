.class public Lorg/drinkless/tdlib/TdApi$ChatActionUploadingVideoNote;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionUploadingVideoNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x45e0de76


# instance fields
.field public progress:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9655
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9645
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9646
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionUploadingVideoNote;->progress:I

    .line 9647
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9651
    const v0, 0x45e0de76

    return v0
.end method
