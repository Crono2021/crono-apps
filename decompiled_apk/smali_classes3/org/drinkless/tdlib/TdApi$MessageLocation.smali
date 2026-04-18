.class public Lorg/drinkless/tdlib/TdApi$MessageLocation;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x121e4474


# instance fields
.field public expiresIn:I

.field public heading:I

.field public livePeriod:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public proximityAlertRadius:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48139
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;IIII)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "i12"    # I

    .line 48125
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48126
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 48127
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$MessageLocation;->livePeriod:I

    .line 48128
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$MessageLocation;->expiresIn:I

    .line 48129
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$MessageLocation;->heading:I

    .line 48130
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$MessageLocation;->proximityAlertRadius:I

    .line 48131
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48135
    const v0, 0x121e4474

    return v0
.end method
