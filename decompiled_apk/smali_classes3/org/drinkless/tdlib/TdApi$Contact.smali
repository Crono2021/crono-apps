.class public Lorg/drinkless/tdlib/TdApi$Contact;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Contact"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76d7a88c


# instance fields
.field public firstName:Ljava/lang/String;

.field public lastName:Ljava/lang/String;

.field public phoneNumber:Ljava/lang/String;

.field public userId:J

.field public vcard:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46865
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "j5"    # J

    .line 46851
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46852
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Contact;->phoneNumber:Ljava/lang/String;

    .line 46853
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Contact;->firstName:Ljava/lang/String;

    .line 46854
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Contact;->lastName:Ljava/lang/String;

    .line 46855
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Contact;->vcard:Ljava/lang/String;

    .line 46856
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$Contact;->userId:J

    .line 46857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46861
    const v0, -0x76d7a88c

    return v0
.end method
