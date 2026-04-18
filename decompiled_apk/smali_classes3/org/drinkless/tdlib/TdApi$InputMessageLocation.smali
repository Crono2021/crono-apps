.class public Lorg/drinkless/tdlib/TdApi$InputMessageLocation;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x26aae970


# instance fields
.field public heading:I

.field public livePeriod:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public proximityAlertRadius:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43926
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 43927
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;III)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I

    .line 43914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 43915
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 43916
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageLocation;->livePeriod:I

    .line 43917
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageLocation;->heading:I

    .line 43918
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageLocation;->proximityAlertRadius:I

    .line 43919
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43923
    const v0, 0x26aae970

    return v0
.end method
