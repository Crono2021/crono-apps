.class public Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditInlineMessageLiveLocation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7f37a0ac


# instance fields
.field public heading:I

.field public inlineMessageId:Ljava/lang/String;

.field public livePeriod:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public proximityAlertRadius:I

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49702
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49703
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$Location;III)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p3, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "i11"    # I

    .line 49688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49689
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;->inlineMessageId:Ljava/lang/String;

    .line 49690
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 49691
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 49692
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;->livePeriod:I

    .line 49693
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;->heading:I

    .line 49694
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageLiveLocation;->proximityAlertRadius:I

    .line 49695
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49699
    const v0, 0x7f37a0ac

    return v0
.end method
