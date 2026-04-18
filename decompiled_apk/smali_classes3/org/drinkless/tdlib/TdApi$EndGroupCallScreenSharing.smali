.class public Lorg/drinkless/tdlib/TdApi$EndGroupCallScreenSharing;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EndGroupCallScreenSharing"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a0be3b4


# instance fields
.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11886
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11887
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11877
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11878
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EndGroupCallScreenSharing;->groupCallId:I

    .line 11879
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11883
    const v0, -0x7a0be3b4

    return v0
.end method
