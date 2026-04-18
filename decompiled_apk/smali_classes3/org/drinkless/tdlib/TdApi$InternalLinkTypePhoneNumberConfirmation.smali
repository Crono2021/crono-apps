.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypePhoneNumberConfirmation;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypePhoneNumberConfirmation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x68bf6b16


# instance fields
.field public hash:Ljava/lang/String;

.field public phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27745
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 27734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27735
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePhoneNumberConfirmation;->hash:Ljava/lang/String;

    .line 27736
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePhoneNumberConfirmation;->phoneNumber:Ljava/lang/String;

    .line 27737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27741
    const v0, 0x68bf6b16

    return v0
.end method
