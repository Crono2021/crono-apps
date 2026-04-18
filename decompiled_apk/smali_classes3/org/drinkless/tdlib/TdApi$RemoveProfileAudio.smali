.class public Lorg/drinkless/tdlib/TdApi$RemoveProfileAudio;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveProfileAudio"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4d065e7a


# instance fields
.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18510
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18511
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18501
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18502
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveProfileAudio;->fileId:I

    .line 18503
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18507
    const v0, 0x4d065e7a    # 1.4089616E8f

    return v0
.end method
