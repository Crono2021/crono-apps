.class public Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestedPostInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x40de9fbe


# instance fields
.field public canBeApproved:Z

.field public canBeDeclined:Z

.field public price:Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

.field public sendDate:I

.field public state:Lorg/drinkless/tdlib/TdApi$SuggestedPostState;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49022
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49023
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;ILorg/drinkless/tdlib/TdApi$SuggestedPostState;ZZ)V
    .locals 0
    .param p1, "suggestedPostPrice"    # Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;
    .param p2, "i9"    # I
    .param p3, "suggestedPostState"    # Lorg/drinkless/tdlib/TdApi$SuggestedPostState;
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z

    .line 49009
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49010
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;->price:Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

    .line 49011
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;->sendDate:I

    .line 49012
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;->state:Lorg/drinkless/tdlib/TdApi$SuggestedPostState;

    .line 49013
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;->canBeApproved:Z

    .line 49014
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;->canBeDeclined:Z

    .line 49015
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49019
    const v0, -0x40de9fbe

    return v0
.end method
