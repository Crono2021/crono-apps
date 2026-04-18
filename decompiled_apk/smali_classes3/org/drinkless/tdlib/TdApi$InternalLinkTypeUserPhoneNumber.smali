.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUserPhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeUserPhoneNumber"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x104bbb08


# instance fields
.field public draftText:Ljava/lang/String;

.field public openProfile:Z

.field public phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38239
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 38227
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38228
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUserPhoneNumber;->phoneNumber:Ljava/lang/String;

    .line 38229
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUserPhoneNumber;->draftText:Ljava/lang/String;

    .line 38230
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUserPhoneNumber;->openProfile:Z

    .line 38231
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38235
    const v0, 0x104bbb08

    return v0
.end method
