.class public Lorg/drinkless/tdlib/TdApi$AddProfileAudio;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddProfileAudio"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17700b1f


# instance fields
.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8665
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 8655
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8656
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AddProfileAudio;->fileId:I

    .line 8657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8661
    const v0, 0x17700b1f

    return v0
.end method
