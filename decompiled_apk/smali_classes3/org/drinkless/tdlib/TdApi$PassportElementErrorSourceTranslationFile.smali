.class public Lorg/drinkless/tdlib/TdApi$PassportElementErrorSourceTranslationFile;
.super Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementErrorSourceTranslationFile"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x291ac8ec


# instance fields
.field public fileIndex:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;-><init>()V

    .line 17485
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 17475
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;-><init>()V

    .line 17476
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementErrorSourceTranslationFile;->fileIndex:I

    .line 17477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17481
    const v0, -0x291ac8ec

    return v0
.end method
