.class public Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;
.super Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "KeyboardButtonTypeRequestUsers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x67a37403


# instance fields
.field public id:I

.field public maxQuantity:I

.field public requestName:Z

.field public requestPhoto:Z

.field public requestUsername:Z

.field public restrictUserIsBot:Z

.field public restrictUserIsPremium:Z

.field public userIsBot:Z

.field public userIsPremium:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 52835
    return-void
.end method

.method public constructor <init>(IZZZZIZZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z
    .param p6, "i10"    # I
    .param p7, "z12"    # Z
    .param p8, "z13"    # Z
    .param p9, "z14"    # Z

    .line 52817
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 52818
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->id:I

    .line 52819
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->restrictUserIsBot:Z

    .line 52820
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->userIsBot:Z

    .line 52821
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->restrictUserIsPremium:Z

    .line 52822
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->userIsPremium:Z

    .line 52823
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->maxQuantity:I

    .line 52824
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->requestName:Z

    .line 52825
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->requestUsername:Z

    .line 52826
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestUsers;->requestPhoto:Z

    .line 52827
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52831
    const v0, -0x67a37403

    return v0
.end method
