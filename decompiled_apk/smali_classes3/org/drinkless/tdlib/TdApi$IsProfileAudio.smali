.class public Lorg/drinkless/tdlib/TdApi$IsProfileAudio;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "IsProfileAudio"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xea58822


# instance fields
.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15540
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 15541
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 15531
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 15532
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$IsProfileAudio;->fileId:I

    .line 15533
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15537
    const v0, -0xea58822

    return v0
.end method
