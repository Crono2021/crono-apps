.class public Lorg/drinkless/tdlib/TdApi$GetStickerSetName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStickerSetName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3dfad681


# instance fields
.field public setId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13669
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13659
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13660
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStickerSetName;->setId:J

    .line 13661
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13665
    const v0, 0x3dfad681

    return v0
.end method
