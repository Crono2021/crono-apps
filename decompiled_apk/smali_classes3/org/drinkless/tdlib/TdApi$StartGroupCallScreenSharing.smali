.class public Lorg/drinkless/tdlib/TdApi$StartGroupCallScreenSharing;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StartGroupCallScreenSharing"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x34b1ced3


# instance fields
.field public audioSourceId:I

.field public groupCallId:I

.field public payload:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40746
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40747
    return-void
.end method

.method public constructor <init>(IILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "str"    # Ljava/lang/String;

    .line 40735
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40736
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallScreenSharing;->groupCallId:I

    .line 40737
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallScreenSharing;->audioSourceId:I

    .line 40738
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallScreenSharing;->payload:Ljava/lang/String;

    .line 40739
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40743
    const v0, -0x34b1ced3    # -1.3513005E7f

    return v0
.end method
