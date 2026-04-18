.class public Lorg/drinkless/tdlib/TdApi$GetPhoneNumberInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPhoneNumberInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5fdd6407


# instance fields
.field public phoneNumberPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13236
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13237
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 13227
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13228
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPhoneNumberInfo;->phoneNumberPrefix:Ljava/lang/String;

    .line 13229
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13233
    const v0, -0x5fdd6407

    return v0
.end method
